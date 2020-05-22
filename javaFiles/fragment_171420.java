CREATE TABLE IF NOT EXISTS `target` (
  `applicationPeriodId` bigint(20) NOT NULL,
  `employeeId` bigint(20) NOT NULL,
  `projectClassId` bigint(20) NOT NULL,
  `target` int(11) NOT NULL,
  PRIMARY KEY (`applicationPeriodId`,`employeeId`,`projectClassId`),
  KEY `FKCB7E71913353DC5C` (`employeeId`),
  KEY `FKCB7E7191A520201E` (`projectClassId`),
  KEY `FKCB7E7191790761A4` (`applicationPeriodId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for table `target`
--
ALTER TABLE `target`
  ADD CONSTRAINT `FKCB7E7191790761A4` FOREIGN KEY (`applicationPeriodId`) REFERENCES `ApplicationPeriod` (`id`),
  ADD CONSTRAINT `FKCB7E71913353DC5C` FOREIGN KEY (`employeeId`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FKCB7E7191A520201E` FOREIGN KEY (`projectClassId`) REFERENCES `project_class` (`id`);