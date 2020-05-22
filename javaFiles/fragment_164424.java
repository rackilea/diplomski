public String getIcon(String extension) {
        String icon;

        System.out.println(extension);

        switch (extension) {
                // cases go here
                case ".css":
                    icon = "css.svg";
                    break;
        }
        return icon;
}