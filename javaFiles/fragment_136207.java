for (final ITemplateResolver templateResolver : configuration.getTemplateResolvers()) {

            final TemplateResolution templateResolution =
                    templateResolver.resolveTemplate(configuration, ownerTemplate, template, templateResolutionAttributes);
            if (templateResolution != null) {
                if (logger.isTraceEnabled()) {
                    logger.trace(
                            "[THYMELEAF][{}] Template resolver match! Resolver \"{}\" will resolve template \"{}\"",
                            new Object[] {TemplateEngine.threadIndex(), templateResolver.getName(), LoggingUtils.loggifyTemplateName(template)});
                }
                return templateResolution;
            }

            if (logger.isTraceEnabled()) {
                    logger.trace(
                            "[THYMELEAF][{}] Skipping template resolver \"{}\" for template \"{}\"",
                            new Object[] {TemplateEngine.threadIndex(), templateResolver.getName(), LoggingUtils.loggifyTemplateName(template)});
            }

        }