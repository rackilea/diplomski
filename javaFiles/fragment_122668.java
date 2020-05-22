function mapToObj(strMap) {
        let obj = Object.create(null);
        for (let [k,v] of strMap) {
            obj[k] = v; //look out! Key must be a string!
        }
        return obj;
    }