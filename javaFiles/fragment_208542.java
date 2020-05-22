public static void main(String[] args) {

    while(true) {        
        Scanner keyboard = new Scanner(System.in);
        String menu = "";
        System.out.println("Uğur Can'ın mini oyununa hoşgeldiniz!!!");
        System.out.println("---------------------------------------");
        System.out.println("Başlamak için 'Başla'.");
        System.out.println("Oyun öncesi bilgiler için 'Bilgiler'.");
        System.out.println("Jenerik için 'Jenerik' yazınız.");
        System.out.print(">");
        menu = keyboard.nextLine();

        if(menu.equals("Bilgiler")) {       
            System.out.println("Oyun metin-bazlı bir kısa oyundur.");
            System.out.println("Oyun sırasında '>' işareti görürseniz bilin ki sizden bir girdi bekleniyordur.");
            System.out.println("Oyun sırasında genellikle iki şık olur ve birini seçmeniz istenir.");
            System.out.println("Şıklar büyük harflerle yazılmıştır.");
            System.out.println("Bir şık yazacağınız zaman ilk harfi büyük olacak şekilde yazın.");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Menüye dönmek için 'Geri' yazınız.");
            System.out.print(">");
            menu = keyboard.nextLine();
        }
        if(menu.equals("Geri")) {   
            System.out.println("Uğur Can'ın mini oyununa hoşgeldiniz!!!");  
            System.out.println("Başlamak için 'Başla'.");
            System.out.println("Oyun öncesi bilgiler için 'Bilgiler'.");
            System.out.println("Jenerik için 'Jenerik' yazınız.");
            System.out.print(">");
            menu = keyboard.nextLine();
        }
        if(menu.equals("Jenerik")) {
            System.out.println("Yapımcı: Uğur Can Aydın");
            System.out.println("Senaryo: Uğur Can Aydın");
            System.out.println("Yazılım: Uğur Can Aydın");
            System.out.print(">");
            System.out.println("Menüye dönmek için 'Geri' yazınız.");
            System.out.print(">");
            menu = keyboard.nextLine();
        }
        if(menu.equals("Geri")) {   
            System.out.println("Uğur Can'ın mini oyununa hoşgeldiniz!!!");  
            System.out.println("Başlamak için 'Başla'.");
            System.out.println("Oyun öncesi bilgiler için 'Bilgiler'.");
            System.out.println("Jenerik için 'Jenerik' yazınız.");
            System.out.print(">");
            menu = keyboard.nextLine();
        }
    }
}