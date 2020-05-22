//The mmcpath is the path to the image
BufferedImage image = ImageUtil.getImageFromPath(mmcpath);

if (image != null) {

    image = ImageUtil.resize(image, width, height);

    response.setContentType("images/jpg");
    response.setHeader("Content-Type", FileHelper.getNameFromPath(mmcpath));
    response.setHeader("Content-Disposition", "inline; filename=\"" + FileHelper.getNameFromPath(mmcpath) + "\"");

    OutputStream out = response.getOutputStream();
    ImageIO.write(image, "jpg", out);
    out.close();

    return Response.ok().build();
}