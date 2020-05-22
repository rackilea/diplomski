@PostMapping(path="/upload")
    public ResponseEntity<Properties> uploadAttachment(@RequestHeader(IRSConsts.UID) String uid, @RequestParam("file") MultipartFile mFile) {
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        ByteArrayResource contentsAsResource = null;
        try {
            contentsAsResource = new ByteArrayResource(mFile.getBytes()) {
                @Override
                public String getFilename() {
                    return mFile.getOriginalFilename();
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
        multiValueMap.add("file", contentsAsResource);
        return transSvcClient.upload(uid, multiValueMap);
    }