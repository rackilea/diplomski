printAnalytics("before test");

            Array<BitmapFont> fonts = new Array<BitmapFont>();
            // create a sample parameters
            FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
            params.size = 12;
            params.minFilter = Texture.TextureFilter.Nearest;
            params.magFilter = Texture.TextureFilter.Nearest;

            // load the font
            FileHandle fontFile = Gdx.files.internal("arial.ttf");
            for (int i = 0; i < 2000; i++) {
                // generate it
                FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
                BitmapFont bitmapFont = generator.generateFont(params);
                bitmapFont.setUseIntegerPositions(false);
                generator.dispose();

                // add to array
                fonts.add(bitmapFont);
            }

            printAnalytics("before disposing, before first gc");
            System.gc();
            printAnalytics("before disposing, after first gc");
            // dispose all fonts
            for (BitmapFont font : fonts) {
                font.dispose();
            }
            // clear array
            fonts.clear();
            printAnalytics("after disposing, before second gc");
            System.gc();
            printAnalytics("after disposing, after second gc");