@Override
        public boolean accept(File dir, String name) {
            Date dirDate = null;
            try {
                dirDate = DATE_FORMAT.parse(name.trim());
            } catch(Exception e) {
                System.out.println("Cannot parse date "+name+" reason "+e.getMessage());
                return false;
            }

            String dirDateStr = DATE_FORMAT.format(dirDate);

            return initialDate.compareTo(dirDateStr) * dirDateStr.compareTo(endingDate) > 0;
        }