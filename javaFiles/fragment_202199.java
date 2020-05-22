ECPrivateKeyParameters ecPriv = ...; // this is the user's EC private key (not ephemeral)

FixedSecureRandom fsr_k = new FixedSecureRandom();
fsr_k.setBytes(tempKeyK);

ECDSASigner signer = new ECDSASigner();
ParametersWithRandom ecdsaprivrand = new ParametersWithRandom(ecPriv, fsr_k);
signer.init(true, ecdsaprivrand);