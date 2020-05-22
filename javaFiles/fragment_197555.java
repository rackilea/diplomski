@ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "merchant_id")
        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        @Getter(onMethod = @__( @JsonIgnore))
        @Setter
        private Merchant merchant;