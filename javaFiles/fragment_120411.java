Producto stockProducto=new Producto();
stockProducto.setNomProducto("Steel Bike");
stockProducto.setCodeProducto("BIC001");
stockProducto.setPrice(190000);
getMapProducto().put(1, stockProducto);

stockProducto = new Producto(); // You forgot this
stockProducto.setNomProducto("Aluminium Bike");
stockProducto.setCodeProducto("BIC002");
stockProducto.setPrice(290000);
getMapProducto().put(1, stockProducto);