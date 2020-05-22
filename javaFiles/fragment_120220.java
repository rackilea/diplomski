Collections.sort(programs, new Comparator<Main>() {
        @Override
        public int compare(Program a, Program b) {
            int comparison = 0;
        try {
            comparison = SDF.parse(a.getCreatedDate()).compareTo(SDF.parse(b.getCreatedDate()));
        } catch (ParseException e) {
            // handle it!!
        }
        return asc ? comparison : (0-comparison);
        }
    });