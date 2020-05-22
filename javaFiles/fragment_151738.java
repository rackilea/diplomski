private class UpdateThread extends TimerTask
{
    private PlotValuesContainer l_dataContainer;

    @Override
    public boolean cancel()
    {
        return super.cancel();
    }

    @Override
    public void run()
    {
        l_dataContainer = new PlotValuesContainer();
        //store time stamp
        l_dataContainer.setTimeStamp(java.time.LocalDateTime.now());

        //store signal values
        final short[] l_Array1to256 = new short[256];
        for (int i = 0; i < l_Array1to256.length; i++)
        {
            l_Array1to256[i] = (short) (Math.random() * Short.MAX_VALUE);
        }
        l_dataContainer.setSignal(l_Array1to256);

        if (m_logData.size() > 0)
        {
            System.out.println("A - oldest: " + m_logData.get(0).getTimeStamp().toString());
        }
        m_logData.add(l_dataContainer);

        System.out.println("B - newest: " + m_logData.get((m_logData.size() - 1)).getTimeStamp().toString());

        for (int i = 0; i < m_logData.size(); i++)
        {
            System.out.println("C - all: " + m_logData.get(i).getTimeStamp().toString());
        }
    }
}