// async collect id -> version map
    Mono<Map<Long, TemplateVersionBo>> templateVersionsMapMono =
            templateVerion.collectMap(TemplateVersionBo::getTemplateId);

    // get version from map by template id
    Flux<TemplateBo> templateBoFlux = templateVersionsMapMono
            .flatMapMany(templateVersionsMap -> template
                    .map(templateBo -> templateBo.withTemplatePublishedVersion(
                            templateVersionsMap.get(templateBo.getId()).getVersion())));