if (this.scanner != null)
        {
            this.source.setScanner(this.scanner);
        }
        else
        {
            if (this.filter != null)
            {
                if (this.locker == null)
                {
                    this.source.setFilter(this.filter);
                }
                else
                {
                    CompositeFileListFilter<File> compositeFileListFilter = new CompositeFileListFilter<File>();
                    compositeFileListFilter.addFilter(this.filter);
                    compositeFileListFilter.addFilter(this.locker);
                    this.source.setFilter(compositeFileListFilter);
                    this.source.setLocker(locker);
                }
            }
            else if (this.locker != null)
            {
                CompositeFileListFilter<File> compositeFileListFilter = new CompositeFileListFilter<File>();
                compositeFileListFilter.addFilter(new FileListFilterFactoryBean().getObject());
                compositeFileListFilter.addFilter(this.locker);
                this.source.setFilter(compositeFileListFilter);
                this.source.setLocker(locker);
            }
        }