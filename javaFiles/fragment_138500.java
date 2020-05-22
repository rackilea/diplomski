@Override
    @Transactional
    public FirmDTO save (FirmDTO firmDTO) {
        log.info("Database Request to save Firm: {}", firmDTO.getFirmId());
        Firm firm = firmMapper.firmDTOtoFirm(firmDTO);
        try {
            firm = firmRepository.saveAndFlush(firm);
            firmSearchRepository.save(firm);
            return firmMapper.firmToFirmDTO(firm);
        } catch (DataAccessException ex) {
            log.error("my exception");
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }