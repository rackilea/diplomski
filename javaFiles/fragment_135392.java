return Flux.fromIterable(outletEntity.getEmployees()) (1)
        .flatMap(this.employeeService.getRepository()::existsById)
        .doOnNext(System.out::println)
        .map(aBoolean -> {
            if (!aBoolean) { (2)
                throw new ApiExceptionUtils("tenant not found", HttpStatus.UNPROCESSABLE_ENTITY.value(),
                    StatusCodeUtils.TENANT_NOT_FOUND);
            }
            else {
                return aBoolean;
            }
        })
        .then(Mono.just(outletEntity)) (3)
        .flatMap(outletEntity1 -> {
            outletEntity.setTenantId(tenantId);
            return  this.outletRepository.save(outletEntity);
        });