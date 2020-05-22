log4j.appender.A1 = org.apache.log4j.ConsoleAppender
log4j.appender.A1.layout = org.apache.log4j.PatternLayout
log4j.appender.A1.layout.ConversionPattern = %d{HH:mm:ss,SSS} (%t) %-5p [%c] - %m%n

[...]

# Tighten logging on the DataNucleus categories to WARN.
# This DataNucleus logging configuration appears redundant; in production,
# DataNucleus uses Java logging instead.
log4j.logger.DataNucleus                 = WARN, A1
log4j.logger.DataNucleus.JDO             = WARN, A1
log4j.logger.DataNucleus.Persistence     = WARN, A1
log4j.logger.DataNucleus.Query           = WARN, A1
log4j.logger.DataNucleus.Lifecycle       = WARN, A1
log4j.logger.DataNucleus.Cache           = WARN, A1
log4j.logger.DataNucleus.MetaData        = WARN, A1
log4j.logger.DataNucleus.Management      = WARN, A1
log4j.logger.DataNucleus.General         = WARN, A1
log4j.logger.DataNucleus.Connection      = WARN, A1
log4j.logger.DataNucleus.Transaction     = WARN, A1
log4j.logger.DataNucleus.Datastore       = WARN, A1
log4j.logger.DataNucleus.ClassLoading    = WARN, A1
log4j.logger.DataNucleus.Plugin          = WARN, A1
log4j.logger.DataNucleus.ValueGeneration = WARN, A1
log4j.logger.DataNucleus.Enhancer        = WARN, A1
log4j.logger.DataNucleus.SchemaTool      = WARN, A1