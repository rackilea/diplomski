@Override
@Transactional
public CatalogImage saveOrUpdateCatalogImage(String category, MultipartFile image) throws Exception {
    CatalogImage img = new CatalogImage();
    byte[] imageData = new byte[(int) image.length()];
    try {
    FileInputStream fileInputStream = new FileInputStream(image);
    fileInputStream.read(imageData);
    fileInputStream.close();
    } catch (Exception e) {
    e.printStackTrace();
    }
    img.setCatlogImg(imageData);
    img.setCategory(category);
    img.setImageName(image.getOriginalFilename());
    img.setImgSize(image.getSize());
    this.sessionFactory.getCurrentSession().saveOrUpdate(img);
    return img;
}