publuc class Args {
  id: string;
  val: string;
}


delete(id: number) {
   let optionsArray: Args[] = [
      {id: "id" val: id.toString()}
    ];
   return this.http.delete(this.articulosURL, this.addRequestOptions(oprionsArray, null)).map(() => null);
}

/***
 * Generates default headers I.E. #Authorization and append any optional headers provided
 * @param {Args[]} args an array of Args[KEY, Value]
 * @returns {Headers}
 */
private addHeader(args: Args[]): Headers {
  let headers: Headers = new Headers();

  // Use this block only if you have Spring OAuth2 security or any other security that require Authorization client id 
    let a: Args = new Args;
    a.id = "Authorization";
    a.val = "your client id";
    headers.append(a.id, a.val);
  // END

  if (args == null) return headers;
  args.forEach(a => {
    headers.append(a.id, a.val);
  });
  return headers;
}

/***
 * Generates default headers as default option and add any provided search parameters to the #RequestOptions
 * @param {Args[]} args an array of request parameters
 * @param {Args[]} headers an array of optional headers
 * @returns {RequestOptions}
 */
private addRequestOptions(args: Args[], headers: Args[]): RequestOptions {
  let options: RequestOptions = new RequestOptions();
  options.headers = this.addHeader(headers);
  options.params = new URLSearchParams();
  if (args == null || args == []) return options;
  args.forEach(a => {
    options.params.append(a.id, a.val);
  });
  return options;
}