try {



                Desktop.getDesktop().browse(new URI("http://maps.google.com/maps?saddr=Current%20Location&daddr=52.5651667, -8.7895846"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }