@Override
    public void onFrameAvailable( SurfaceTexture pSurfaceTexture )
    {
        try
        {
            GUIThreadLock.acquire();
            if( written )
            {
                pSurfaceTexture.releaseTexImage();
            }
            pSurfaceTexture.updateTexImage();
            written = true;
        }
        finally
        {
            GUIThreadLock.relinquish();
        }
    }