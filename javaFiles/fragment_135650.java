public enum CertificateFunnel
    implements Funnel<Certificate>
{
    INSTANCE
    {
        @Override
        public void funnel(final Certificate from, final PrimitiveSink into)
        {
            into.putBytes(from.getEncoded());
        }
    }
}