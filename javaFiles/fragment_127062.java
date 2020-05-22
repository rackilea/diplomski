WandShopController wandShopController = new WandShopController();
FXMLLoader loader = new FXMLLoader();
loader.setLocation(WandShopController.class.getResource("Scene1FXML.fxml"));
loader.setController(wandShopController); // Set the correct controller
loader.load(); // You probably need to store the root node, depending on what you are trying to do
wandShopController.loaduserBox(user.get(i).getWood(), user.get(i).getCore(), user.get(i).getLength(),user.get(i).getQuality());