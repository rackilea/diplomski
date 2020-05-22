public class AssetRate {

        private Integer id_asset_rate;
        private Integer id_asset;
        private Double value;
        private Double loan_to_value;
        private Double offered;
        private Double annual_rate;
        private String updated_at;

        public Integer getId_asset_rate() {
            return id_asset_rate;
        }

        public void setId_asset_rate(Integer id_asset_rate) {
            this.id_asset_rate = id_asset_rate;
        }

        public Integer getId_asset() {
            return id_asset;
        }

        public void setId_asset(Integer id_asset) {
            this.id_asset = id_asset;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        public Double getLoan_to_value() {
            return loan_to_value;
        }

        public void setLoan_to_value(Double loan_to_value) {
            this.loan_to_value = loan_to_value;
        }

        public Double getOffered() {
            return offered;
        }

        public void setOffered(Double offered) {
            this.offered = offered;
        }

        public Double getAnnual_rate() {
            return annual_rate;
        }

        public void setAnnual_rate(Double annual_rate) {
            this.annual_rate = annual_rate;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }