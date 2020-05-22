try {
        String tglSatu = "2019-01-07";
        LocalDate tglAwal = LocalDate.parse(tglSatu);
        String tglDua = "2019-01-18";
        LocalDate tglAkhir = LocalDate.parse(tglDua);

        long bedaHari = ChronoUnit.DAYS.between(tglAwal, tglAkhir);
        if (bedaHari < 0) {
            bedaHari = 0;
        }
        System.out.println("" + bedaHari + " hari");

    } catch (DateTimeParseException dtpe){
         System.out.println(dtpe.getMessage());
    }