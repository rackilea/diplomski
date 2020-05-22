try {
            player = Manager.createRealizedPlayer(cdi.getLocator());
            player.start();
        } catch (NoPlayerException e) {
            e.printStackTrace();
        } catch (CannotRealizeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            new Timer(3000, this).start();
        // Grab a frame from the capture device
        frameGrabber = (FrameGrabbingControl) player
                .getControl("javax.media.control.FrameGrabbingControl");