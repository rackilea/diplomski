public static void main(String[] args) {
     try {
        String theksn = "This should be your KSN";
        String encrypted = "This should be the encrypted data";
        String BDK = "The BDK you mentioned up there";

            tracking= DukptDecrypt.decrypt(theksn, BDK, encrypted);

            System.out.print("PlainText"+ tracking);
        }catch (Exception e){System.out.print(e);}

    }