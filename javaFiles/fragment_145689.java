public class Buffer {
    private class BufferImpl{
        public int mCapacity;
        public int mMask;
        public byte[] mBacking;
        public long mRead,mWrite;
        @Override
        public String toString() {
            int ca=mCapacity;
            char[] cs=new char[ca+ca+ca+2];
            for(int i=0;i<cs.length;i++)
                cs[i]=' ';
            byte[] bk=mBacking;
            cs[ca]='\n';
            cs[ca+ca+1]='\n';
            for(int i=0;i<ca;i++)
                cs[i]=bk[i]=='\n'||bk[i]=='\r'?'.':(char)bk[i];
            int r=(int)mRead&mMask;
            int w=(int)mWrite&mMask;
            if(mRead==mWrite)return new String(cs);
            if(r<w){
                for(int i=r;i<w;i++)
                    cs[i+ca+1]=bk[i]=='\n'||bk[i]=='\r'?'.':(char)bk[i];
                return new String(cs);
            }else{
                for(int i=r;i<ca;i++)
                    cs[i+ca+1]=bk[i]=='\n'||bk[i]=='\r'?'.':(char)bk[i];
                for(int i=0;i<w;i++)
                    cs[i+ca+ca+2]=bk[i]=='\n'||bk[i]=='\r'?'.':(char)bk[i];
                return new String(cs);
            }
        }
        public BufferImpl(int capacity){
            checkAndSetCapacity(capacity);
            mBacking=new byte[capacity];
        }
        public BufferImpl(byte[] backing){
            checkAndSetCapacity(backing.length);
            mBacking=backing;
        }
        private void checkAndSetCapacity(int capacity){
            if((mMask&capacity)!=0)
                throw new IllegalArgumentException("capacity "+capacity+" is not a power of 2");
            mMask=capacity-1;
            mCapacity=capacity;
        }
    }
    private BufferImpl impl;
    private Buffer lower;
    @Override
    public String toString() {
        return impl.toString();
    }
    public Buffer(int capacity){
        impl=new BufferImpl(capacity);
    }
    public Buffer(byte[] backing){
        impl=new BufferImpl(backing);
    }
    public Buffer(Buffer lower){
        this.lower=lower;
        this.impl=lower.impl;
    }

    public int availableRead(){
        if(lower!=null)
            return lower.availableRead();
        return (int)(impl.mWrite-impl.mRead);
    }
    public int availableWrite(){
        if(lower!=null)
            return lower.availableWrite();
        return capacity()-(int)(impl.mWrite-impl.mRead);
    }
    public int capacity(){
        if(lower!=null)
            return lower.capacity();
        return impl.mCapacity;
    }
    protected void onReset(){
        if(lower!=null)
            lower.onReset();
    }
    public final void reset(){
        onReset();
        impl.mRead=impl.mWrite=0;
    }
    protected void onReadComplete(int read){
        if(lower!=null)
            lower.onReadComplete(read);
    }
    public final void confirmRead(int read){
        onReadComplete(read);
        impl.mRead+=read;
    }
    public final int peek(byte[] out, int offset, int length){
        if(length==-1) length=out.length-offset;
        int effectiveLen=availableRead();
        if(length<effectiveLen) effectiveLen=length;
        if(effectiveLen>0){
            byte[] backing=impl.mBacking;
            int pos=(int)(impl.mRead & impl.mMask);
            int capacity=capacity();
            if(pos+effectiveLen>capacity){
                int left=effectiveLen-(capacity-pos);
                do{out[offset++]=backing[pos++];
                }while(pos<capacity);pos=0;
                do{out[offset++]=backing[pos++];
                }while(pos<left);
            }else{
                int lim=pos+effectiveLen;
                do{out[offset++]=backing[pos++];
                }while(pos<lim);
            }
        }return effectiveLen;
    }
    public final int peek(Buffer out, int length){
        if(length==-1) length=out.availableWrite();
        int effectiveLen=availableRead();
        if(length<effectiveLen) effectiveLen=length;
        if(effectiveLen>0){
            byte[] backing=impl.mBacking;
            int pos=(int)(impl.mRead & impl.mMask);
            int capacity=capacity();
            if(pos+effectiveLen>capacity){
                int p1=capacity-pos;
                int p2=effectiveLen-p1;
                out.write(backing, pos, p1);
                out.write(backing, 0, p2);
            }else out.write(backing, pos, effectiveLen);
        }return effectiveLen;
    }
    public final int read(byte[] out, int offset, int length){
        int len=peek(out, offset, length);
        confirmRead(len);
        return len;
    }
    public final int read(Buffer out, int length){
        int len=peek(out, length);
        confirmRead(len);
        return len;
    }
    protected void onWriteComplete(int written){
        if(lower!=null)
            lower.onWriteComplete(written);
    }
    public final int write(byte[] in, int offset, int length){
        if(length==-1) length=in.length-offset;
        int effectiveLen=availableWrite();
        if(length<effectiveLen) effectiveLen=length;
        if(effectiveLen>0){
            byte[] backing=impl.mBacking;
            int pos=(int)(impl.mWrite & impl.mMask);
            int capacity=capacity();
            if(pos+effectiveLen>capacity){
                int left=effectiveLen-(capacity-pos);
                do{backing[pos++]=in[offset++];
                }while(pos<capacity);pos=0;
                do{backing[pos++]=in[offset++];
                }while(pos<left);
            }else{
                int lim=pos+effectiveLen;
                do{backing[pos++]=in[offset++];
                }while(pos<lim);
            }onWriteComplete(effectiveLen);
            impl.mWrite+=effectiveLen;
            return effectiveLen;
        }onWriteComplete(effectiveLen);
        return effectiveLen;
    }
    public static void main(String[] args) {
        Buffer lower=new Buffer(16){
            @Override
            protected void onWriteComplete(int written) {
                System.out.println("lower.onWriteComplete  "+written);
                super.onWriteComplete(written);
            }
        };
        Buffer higher=new Buffer(lower){
            @Override
            protected void onWriteComplete(int written) {
                System.out.println("higher.onWriteComplete "+written);
                super.onWriteComplete(written);
            }
        };
        higher.write(new byte[0], 0, -1);
    }
}