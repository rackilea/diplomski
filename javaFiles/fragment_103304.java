public boolean handleMessage(Message msg) {
    switch(msg.what) {
        case MESSAGE_FROM_MAIN_THREAD:
            try {
                m_Semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            loadTextureFromAssets(msg.obj.toString(), msg.arg1);

            break;

        case MESSAGE_FROM_GL_THREAD:
            // not needed for now
            break;

    }

    return true;
}