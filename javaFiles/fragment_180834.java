ColorSpace colorSpace = img.getColorModel().getColorSpace();
if ( colorSpace instanceof ICC_ColorSpace ) {
    ICC_Profile profile = ((ICC_ColorSpace)colorSpace).getProfile();
    if ( profile instanceof ICC_ProfileGray ) {
        float gamma = ((ICC_ProfileGray)profile).getGamma();
        system.out.println("Gray Profile Gamma: "+gamma); // 1.0 !
    }
}