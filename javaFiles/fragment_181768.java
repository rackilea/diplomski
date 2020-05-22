public static final String CREATE_TABEL_MAHASISWA = "CREATE TABLE IF NOT EXISTS "
            + TABEL_MAHASISWA + "(" + ID + " INTEGER PRIMARY KEY, "
            + NAMA + " TEXT, " + JURUSAN + " TEXT, "
            + TANGGAL_LAHIR + " DATE" + ")"
            + TABEL_ANGKATAN + " TEXT"+");";

//corrected the second query as it was incomplete
    public static final String CREATE_TABEL_ANGKATAN = "CREATE TABLE IF NOT EXISTS "
            + TABEL_ANGKATAN + "(" + ID + " INTEGER PRIMARY KEY,"
            + NAMA + " TEXT"+");";