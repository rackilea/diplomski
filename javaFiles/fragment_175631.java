// 
// @param dependant_textures is a vector of textures where 
// texture n+1 depends on texture n. 
// @param combimed_tex is the output of all textures combined
void Sprite::combineTextures (vector<Texture> const& dependant_textures, 
                              Texture& combined_tex) {
   vector< Texture >::iterator iter = dependant_textures.begin();
   combined_tex = *iter;

   if (dependant_textures.size() > 1)
     for (iter++; iter != dependant_textures.end(); iter++) {
        Texture& current_tex = *iter;

        // Go through each pixel, painting:
        for (unsigned char pixel_index = 0; 
             pixel_index < current_tex.numPixels(); pixel_index++) {
           // Assuming that Texture had a method to export the raw pixel data
           // as an array of chars - to illustrate, check Alpha value:
           int const BYTESPERPIXEL = 4; // RGBA
           if (!current_tex.getRawData()[pixel_index * BYTESPERPIXEL + 3]) 
              for (int copied_bytes = 0; copied_bytes < 3; copied_bytes++)
              {
                int index = pixel_index * BYTESPERPIXEL + copied_bytes;
                combined_tex.getRawData()[index] = 
                   current_tex.getRawData()[index];
              }               
        }
     }
}