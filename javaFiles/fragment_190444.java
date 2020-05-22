public static void main(String[] args)
        {
                FastInput input = new FastInput(System.in);
                PrintWriter output = new PrintWriter(System.out);

                for(int i=0;i<10;++i) {
                    output.printf("Hello your num = %d\n" , input.readInt());
                    output.flush();
                }
                input.close();
                output.close();

        }