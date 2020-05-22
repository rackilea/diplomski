public void render() {
     for(int y = 0; y < h; y++) {
          if(y >= sheet.h) continue; //prevent going out of bounds on y-axis
          for(int x = 0; x < w; x++) {
              if(x >= sheet.w) continue; //prevent going out of bounds on x-axis
                  pixels[x + y * w] = sheet.pixels[x + y * sheet.w];
          }
     }
}