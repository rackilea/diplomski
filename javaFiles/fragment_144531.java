@Cacheable(value="imagesCache",key="'user' + #id_image")
public Image getUserImage(id_image){ //stuff }

//and 

@Cacheable(value="imagesCache",key="'product' + #id_image")
public Image getProductImage(id_image){ //stuff }