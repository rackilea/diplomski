new CacheWriter<Long, List<IOperation>>()
            {
                @Override
                public void write(@NotNull final Long key, @NotNull final List<IOperation> value)
                {
                    //On addition
                }

                @Override
                public void delete(@NotNull final Long key, @Nullable final List<IOperation> value, @NotNull final RemovalCause cause)
                {
                    //On removal
                }
            })