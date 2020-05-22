/**
* Extract content from p7m file
*/
    private byte[] getOriginalDocumentBinaries(final byte[] signedDoc) throws SignerException {        
        ASN1InputStream asn1InputStream = null;
        try {
            asn1InputStream = new ASN1InputStream(new ByteArrayInputStream(signedDoc));
            DERObject signedContent;
            try {
                signedContent = asn1InputStream.readObject();
            }
            catch (IOException cause) {
                logger.error(cause.getMessage(), (Throwable)cause);
                throw new SignerException(cause.getMessage(), cause);
            }
            CMSSignedData cmsSignedData;
            try {
                cmsSignedData = new CMSSignedData(ContentInfo.getInstance(signedContent));
            }
            catch (IllegalArgumentException cause2) {
                logger.error(cause2.getMessage(), (Throwable)cause2);
                throw new SignerException(cause2.getMessage(), cause2);
            }catch (Throwable cause2) {
                throw new SignerException(cause2.getMessage(), cause2);
            }
            return (byte[])((CMSProcessableByteArray)cmsSignedData.getSignedContent()).getContent();
        }catch(Exception ex){
            logger.error(ex.getMessage(),ex);
            throw new SignerException(ex);
        }
        finally {
            try {
                asn1InputStream.close();
            }
            catch (IOException ex) {}
        }
    }