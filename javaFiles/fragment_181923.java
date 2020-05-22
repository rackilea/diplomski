public static void main(String[] args) {

            System.out.println(deAccent("Xin chào Việt Nam"));
        }

        public static String deAccent(String str) {
            String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(nfdNormalizedString).replaceAll("");
        }