create table `AssoReadRight_Form` (
    `idProfil` bigint not null,
    `idState` bigint not null,
    `typeForm` varchar(50) not null,
    primary key (`idProfil`, `idState`, `typeForm`),
    constraint `FK_AssoReadRight_Form` foreign key(`idProfil`, `idState`) REFERENCES `ReadWriteRight`(`idProfil`, `idState`)
) engine=InnoDB default charset=utf8;

create table `AssoWriteRight_Form` (
    `idProfil` bigint not null,
    `idState` bigint` not null,
    `typeForm` varchar(50) not null,
    primary key (`idProfil`, `idState`, `typeForm`),
    constraint `FK_AssoWriteRight_Form` foreign key(`idProfil`, `idState`) REFERENCES `ReadWriteRight`(`idProfil`, `idState`)
) engine=InnoDB default charset=utf8;