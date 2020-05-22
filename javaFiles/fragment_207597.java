public class Deneme {
    private static int index = 0;
    private static PazarListesi[] urun;

    public static void main(String[] args) {

        urun = new PazarListesi[300];

        for (int i = 0; i < urun.length; i++) {
            urun[i] = new PazarListesi();
        }

        menu();
    }

    public static void menu() {
        int secim = 0;
        Scanner menuSecim = new Scanner(System.in);

        System.out.println("Pazar Listesine Hoşgeliniz.");
        System.out.println("Menu");
        System.out.println("1. Listeyi Görüntüle");
        System.out.println("2. Listeye Ekle");
        System.out.println("3. Listeden Sil");
        System.out.println("4. Çıkış");
        System.out.print("Seçiminiz: ");
        secim = menuSecim.nextInt();

        if (secim == 1) {
            //
        } else if (secim == 2) {//listeye ekleme
            int eklenilmekIstenen;
            Scanner sayi = new Scanner(System.in);
            System.out.print("Kaç Adet Ürün Eklemek İstiyorsunuz: ");
            eklenilmekIstenen = sayi.nextInt();
            listeyeEkle(eklenilmekIstenen);
        }
    }

    public static void listeyeEkle(int eklenecekSayisi) {
        Scanner str = new Scanner(System.in);
        Scanner sayi = new Scanner(System.in);

        for (int j = index; j < (index + eklenecekSayisi); j++) {
            System.out.print((j + 1) + ". Ürünün Adı: ");
            urun[j].isim = str.nextLine();
            System.out.print((j + 1) + ". Ürünün Miktarı: ");
            urun[j].miktar = sayi.nextFloat();
            System.out.print((j + 1) + ". Ürünün Fiyatı(Kg Bazında): ");
            urun[j].fiyat = sayi.nextFloat();
        }

        index = index + eklenecekSayisi;
        System.out.println("Şu an ki İndex: " + index);

        for (int j = 0; j < index; j++) {
            System.out.println((j + 1) + ". Ürünün Adı: " + urun[j].isim);
            System.out.println((j + 1) + ". Ürünün Miktarı: " + urun[j].miktar);
            System.out.println((j + 1) + ". Ürünün Fiyat: " + urun[j].fiyat);
        }

        menu();
    }

    public static void hepsiniGor() {
        tutarHesapla();
    }

    public static void listedenSil() {
        //
    }

    public static void tutarHesapla() {
        for (int i = 0; i < index; i++) {
            urun[i].tutar = urun[i].miktar * urun[i].fiyat;
        }
    }
}