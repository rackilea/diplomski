axios.post('http://localhost:8090/api/check', {
     "params" : {
         matrix: this.props.rows,
         "row": row - 1,
         "col": col - 1,
         "num": input.textContent
     }
})