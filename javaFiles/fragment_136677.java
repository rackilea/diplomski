CSomeSingleton* CSomeSingleton::GetInstance()
{
    if (m_Instance == NULL)
        m_Instance = new CSomeSingleton();
    return m_Instance;
}