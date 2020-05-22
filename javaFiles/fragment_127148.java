public static void getImage() {
    try {
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        ServletOutputStream responseStream = response.getOutputStream();

        // Add your existing code to create your image here

        // Write the image to the responseStream
        ImageIO.write(img, "png", responseStream);

        FacesContext.getCurrentInstance().responseComplete();
        responseStream.close();
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
}