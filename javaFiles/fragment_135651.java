final Hasher hasher = SHA256.newHasher();

// Funnel the certificate...
hasher.putObject(certificate, CertificateFunnel.INSTANCE);

// Then encode
return BASE32_NOPAD.encode(hasher.hashCode().asBytes());