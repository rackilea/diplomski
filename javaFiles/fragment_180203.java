void SoundPool::notify(SoundPoolEvent event)
{
    Mutex::Autolock lock(&mCallbackLock);
    if (mCallback != NULL) {
        mCallback(event, this, mUserData);
    }
}