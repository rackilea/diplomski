add(new NonCachingImage("imgPlc", new AbstractReadOnlyModel<DynamicImageResource>(){
          @Override public DynamicImageResource getObject() {
            DynamicImageResource dir = new DynamicImageResource() {
              @Override protected byte[] getImageData(Attributes attributes) {
                  StringValue name = parameters.get("name");
                  byte[] imageBytes = null;
                    if(name.isEmpty() == false)
                        imageBytes = getImageAsBytes(name.toString());

                    return imageBytes;
              }
            };
            dir.setFormat("image/png");
            return dir;
          }
        }));