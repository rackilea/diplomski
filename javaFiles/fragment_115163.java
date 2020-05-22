public function handle($request, Closure $next)
    {
        return $next($request)
          ->header('Access-Control-Allow-Origin', '*') //REPLACE STAR WITH YOUR URL
          ->header('Access-Control-Allow-Methods', 'GET, POST, PUT, PATCH, DELETE, OPTIONS')
          ->header('Access-Control-Allow-Headers', 'content-type, authorization, x-requested-with');
    }