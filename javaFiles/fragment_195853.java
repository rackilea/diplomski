try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("tabUserComments.fxml"));
                loader.setController(this);
                this.setContent(loader.load());

            } catch (Exception e) {
                e.printStackTrace();
            }