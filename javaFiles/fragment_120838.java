if (tglAkhir.isBefore(tglAwal)) {
            System.out.println("Tanggal berada dalam urutan yang salah");
        } else {
            long bedaHari = ChronoUnit.DAYS.between(tglAwal, tglAkhir);
            System.out.println("" + bedaHari + " hari");
        }