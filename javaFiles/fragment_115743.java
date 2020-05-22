InputStream input = getClass().getResourceAsStream("/Sound/plague.wav");
       AudioInputStream audioIn = AudioSystem.getAudioInputStream(input);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(knownDiseases.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(knownDiseases.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(knownDiseases.class.getName()).log(Level.SEVERE, null, ex);
        }