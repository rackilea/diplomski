//decls of some partial classes from Skia library
class SkRefCnt{
public:
   virtual ~SkRefCnt(){}
private:
   mutable int fRefCnt;
};

//----------------------------

class SkPixelRef: public SkRefCnt{
public:
   virtual class Factory getFactory() const;
   virtual void flatten(class SkFlattenableWriteBuffer&) const;
protected:
   virtual void* onLockPixels(class SkColorTable**) = 0;
   virtual void onUnlockPixels() = 0;
public:
   void *GetPixels(){
      SkColorTable *ct;
      return onLockPixels(&ct);
   }
};

jobject java_bitmap;  //your Bitmap object
jclass java_bitmap_class = env.GetObjectClass(java_bitmap);
class SkBitmap;
SkBitmap *sk_bitmap = (SkBitmap*)env.CallIntMethod(java_bitmap, env.GetMethodID(java_bitmap_class, "ni", "()I"));
SkPixelRef *sk_pix_ref;
sk_pix_ref = (SkPixelRef*)((int*)sk_bitmap)[1];
// get pointer to Bitmap's pixel memory, and lenght of single line in bytes
int buffer_pitch = env.CallIntMethod(java_bitmap, env.GetMethodID(java_bitmap_class, "getRowBytes", "()I"));
void *buffer = sk_pix_ref->GetPixels();