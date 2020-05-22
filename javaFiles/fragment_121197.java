...
    return Mono.just(file)
        .map(f -> f.transferTo(path))
        .then(Mono.just(uploadedFile))
        .flatMap(uF -> {
            uF.setFilePath(path.toString());
            return repo.save(uF)
        });
}