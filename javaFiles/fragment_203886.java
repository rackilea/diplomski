Rectangle2D rectInSource = ...
Rectangle2D targetRect = ...
gc.drawImage(image,
             rectInSource.getMinX(),
             rectInSource.getMinY(),
             rectInSource.getWidth(),
             rectInSource.getHeight(),
             targetRect.getMinX(),
             targetRect.getMinY(),
             targetRect.getWidth(),
             targetRect.getHeight());